public class BuilderPatternExample {

    // Step 2: Define the Product Class
    public static class Computer {
        // Attributes
        private String CPU;
        private String RAM;
        private String storage;
        private boolean hasGraphicsCard;
        private boolean hasBluetooth;

        // Private constructor
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.hasGraphicsCard = builder.hasGraphicsCard;
            this.hasBluetooth = builder.hasBluetooth;
        }

        // Getters for attributes
        public String getCPU() {
            return CPU;
        }

        public String getRAM() {
            return RAM;
        }

        public String getStorage() {
            return storage;
        }

        public boolean hasGraphicsCard() {
            return hasGraphicsCard;
        }

        public boolean hasBluetooth() {
            return hasBluetooth;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage +
                    ", GraphicsCard=" + (hasGraphicsCard ? "Yes" : "No") +
                    ", Bluetooth=" + (hasBluetooth ? "Yes" : "No") + "]";
        }

        // Step 3: Implement the Builder Class
        public static class Builder {
            // Required parameters
            private String CPU;
            private String RAM;

            // Optional parameters
            private String storage;
            private boolean hasGraphicsCard;
            private boolean hasBluetooth;

            // Constructor for required parameters
            public Builder(String CPU, String RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            // Methods to set optional parameters
            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(boolean hasGraphicsCard) {
                this.hasGraphicsCard = hasGraphicsCard;
                return this;
            }

            public Builder setBluetooth(boolean hasBluetooth) {
                this.hasBluetooth = hasBluetooth;
                return this;
            }

            // Build method
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Step 5: Test the Builder Implementation
    public static void main(String[] args) {
        // Create a Computer with only required parameters
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();

        // Create a Computer with all parameters
        Computer advancedComputer = new Computer.Builder("AMD Ryzen 7", "16GB")
                .setStorage("1TB SSD")
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();

        // Print out the details of each Computer
        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Advanced Computer: " + advancedComputer);
    }
}

