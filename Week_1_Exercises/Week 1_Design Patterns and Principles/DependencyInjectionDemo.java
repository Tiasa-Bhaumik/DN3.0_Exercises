public class DependencyInjectionDemo {

    // Step 2: Define Repository Interface
    interface CustomerRepository {
        String findCustomerById(int id);
    }

    // Step 3: Implement Concrete Repository
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public String findCustomerById(int id) {
            // Simulate a database fetch
            return "Customer with ID " + id;
        }
    }

    // Step 4: Define Service Class
    static class CustomerService {
        private CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public String getCustomerInfo(int id) {
            return repository.findCustomerById(id);
        }
    }

    // Step 6: Test the Dependency Injection Implementation
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        String customerInfo = service.getCustomerInfo(1);
        System.out.println(customerInfo);
    }
}

