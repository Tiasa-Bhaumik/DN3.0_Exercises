public class CommandPatternDemo {

    // Step 2: Define Command Interface
    interface Command {
        void execute();
    }

    // Step 5: Implement Receiver Class
    static class Light {
        void turnOn() {
            System.out.println("Light is ON");
        }

        void turnOff() {
            System.out.println("Light is OFF");
        }
    }

    // Step 3: Implement Concrete Commands
    static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    // Step 4: Implement Invoker Class
    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }

    // Step 6: Test the Command Implementation
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
