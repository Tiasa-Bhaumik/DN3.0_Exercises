public class ProxyPatternDemo {

    // Step 2: Define Subject Interface
    interface Image {
        void display();
    }

    // Step 3: Implement Real Subject Class
    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadImage();
        }

        private void loadImage() {
            System.out.println("Loading image: " + filename);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // Step 4: Implement Proxy Class
    static class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }

    // Step 5: Test the Proxy Implementation
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded and displayed only when needed
        image1.display();
        image1.display(); // Should use cached image

        image2.display();
    }
}

