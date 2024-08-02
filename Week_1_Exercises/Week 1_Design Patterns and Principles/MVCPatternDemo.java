public class MVCPatternDemo {

    // Step 2: Define Model Class
    static class Student {
        private String name;
        private int id;
        private String grade;

        public Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // Step 3: Define View Class
    static class StudentView {
        public void displayStudentDetails(Student student) {
            System.out.println("Student: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Grade: " + student.getGrade());
        }
    }

    // Step 4: Define Controller Class
    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        public void updateView() {
            view.displayStudentDetails(model);
        }
    }

    // Step 5: Test the MVC Implementation
    public static void main(String[] args) {
        Student student = new Student("John Doe", 1, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");
        controller.updateView();
    }
}

