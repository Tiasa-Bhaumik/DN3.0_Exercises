import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {

    // Step 2: Define Subject Interface
    interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }

    // Step 3: Implement Concrete Subject
    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private float stockPrice;

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void deregisterObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockPrice);
            }
        }

        public void setStockPrice(float stockPrice) {
            this.stockPrice = stockPrice;
            notifyObservers();
        }
    }

    // Step 4: Define Observer Interface
    interface Observer {
        void update(float stockPrice);
    }

    // Step 5: Implement Concrete Observers
    static class MobileApp implements Observer {
        @Override
        public void update(float stockPrice) {
            System.out.println("Mobile App: Stock price updated to " + stockPrice);
        }
    }

    static class WebApp implements Observer {
        @Override
        public void update(float stockPrice) {
            System.out.println("Web App: Stock price updated to " + stockPrice);
        }
    }

    // Step 6: Test the Observer Implementation
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.50f);
        stockMarket.setStockPrice(105.75f);
    }
}

