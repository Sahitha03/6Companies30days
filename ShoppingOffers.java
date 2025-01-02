class Solution {
    public int shoppingOffers(List<Integer> itemPrices, List<List<Integer>> specialOffers, List<Integer> remainingNeeds) {
        return calculateMinimumCost(itemPrices, specialOffers, remainingNeeds, 0); 
    }

    public int calculateMinimumCost(List<Integer> itemPrices, List<List<Integer>> specialOffers, List<Integer> remainingNeeds, int offerIndex) {
        int totalCost = 0;
        for (int i = 0; i < remainingNeeds.size(); i++) {
            totalCost += remainingNeeds.get(i) * itemPrices.get(i);
        }

        for (int currentOfferIndex = offerIndex; currentOfferIndex < specialOffers.size(); currentOfferIndex++) {
            List<Integer> currentOffer = specialOffers.get(currentOfferIndex);
            List<Integer> updatedNeeds = new ArrayList<>();
            for (int i = 0; i < remainingNeeds.size(); i++) {
                if (remainingNeeds.get(i) < currentOffer.get(i)) {
                    updatedNeeds = null;
                    break;
                }
                updatedNeeds.add(remainingNeeds.get(i) - currentOffer.get(i));
            }
            if (updatedNeeds != null) {
                totalCost = Math.min(totalCost, currentOffer.get(currentOffer.size() - 1) + calculateMinimumCost(itemPrices, specialOffers, updatedNeeds, currentOfferIndex));
            }
        }
        return totalCost;
    }
}