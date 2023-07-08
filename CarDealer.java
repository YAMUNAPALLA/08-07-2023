public class CarDealer {
    private static final int[] CAR_PRICES = {
        870000,   // Polo Trendline
        1009000,  // Polo Highline
        1105000,  // Virtus Trendline
        1308000,  // Virtus Highline
        1489000,  // Taigun Trendline
        1542000,  // Taigun Highline
        1771000   // Taigun Topline
    };

    private static final int[] ADDITIONAL_FEES = {
        113990,  // RTO
        47300,   // Insurance
        11000,   // TCS charges
        15000    // Additional Accessories
    };

    public int calculateTotalCost(int carIndex, boolean needInsurance, boolean needAccessories, int dealerDiscount) {
        int totalCost = CAR_PRICES[carIndex];

        if (needInsurance) {
            totalCost += ADDITIONAL_FEES[1];
        }
        if (needAccessories) {
            totalCost += ADDITIONAL_FEES[3];
        }

        totalCost += ADDITIONAL_FEES[0];
        totalCost += ADDITIONAL_FEES[2];

        if (dealerDiscount > 30000) {
            dealerDiscount = 30000;
        }

        if (!(needInsurance || needAccessories)) {
            if (dealerDiscount > 0) {
                System.out.println("Error: At least one additional feature must be added when applying a discount.");
                return 0;
            }
        }

        totalCost -= dealerDiscount;

        return totalCost;
    }

    public static void main(String[] args) {
        CarDealer carDealer = new CarDealer();

        int carIndex = 3;  // Virtus Highline
        boolean needInsurance = true;
        boolean needAccessories = false;
        int dealerDiscount = 26160;

        int totalCost = carDealer.calculateTotalCost(carIndex, needInsurance, needAccessories, dealerDiscount);
        if (totalCost != 0) {
            System.out.println("Total cost: " + totalCost);
        }
    }
}
