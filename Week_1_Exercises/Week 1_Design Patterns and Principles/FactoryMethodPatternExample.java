public class FactoryMethodPatternExample {

    // Step 2: Define Document Interfaces
    interface Document {
        void open();
    }

    // Step 3: Create Concrete Document Classes
    static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening a Word document.");
        }
    }

    static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening a PDF document.");
        }
    }

    static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening an Excel document.");
        }
    }

    // Step 4: Implement the Factory Method
    abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Step 5: Test the Factory Method Implementation
    public static void main(String[] args) {
        // Create different document factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Create and open documents using the factories
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        wordDoc.open();
        pdfDoc.open();
        excelDoc.open();
    }
}
