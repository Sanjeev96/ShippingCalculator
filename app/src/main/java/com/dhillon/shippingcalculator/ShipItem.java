package com.dhillon.shippingcalculator;

/**
 * Created by SANJEEV96 on 18/01/2017.
 */
//MODEL
public class ShipItem {

    //static variables - PRICES OF ALL DELIVERY COSTS BASED ON WEIGHT OF ITEM

    static final Double BASE = 3.00;
    static final Double ADDED = 0.50;
    static final double EXTRA_KGS = 4.0;
    static final int BASE_WEIGHT = 16;

    //Data members - USED TO CALCULATE COSTS OF ITEMS BASED ON WEIGHT

    private int iWeight;
    private double iBaseCost;
    private double iAddedCost;
    private double iTotalCost;

        public ShipItem(){// WEIGHT OG ITEMS AND COST SET TO 0 READY FOR PROGRAM INPUT(ALTERATION)
            iWeight = 0;
            iAddedCost = 0.0;
            iBaseCost = BASE;
            iTotalCost = 0.0;
        }

            public void setWeight(int weight){
                iWeight = weight;
                computeCosts();
            }

                private void computeCosts() {
                    iAddedCost = 0.0;
                    iBaseCost = BASE;

                    if (iWeight <= 0)
                        iBaseCost = 0.0;//IF WEIGHT IS ZERO THEN BASE COST IS ZERO
                    else if (iWeight > BASE_WEIGHT) // IF ITEM WEIGHT IS GREATER THAN THE SET BASE WEIGHT THEN ADD ADDTIONAL COSTS FOR
                        // DELIVERY DEPENDING ON WEIGHT
                            iAddedCost = Math.ceil((double)
                               (iWeight-BASE_WEIGHT)/ EXTRA_KGS) * ADDED;

                        iTotalCost = iBaseCost + iAddedCost;
                    }


                    public Double getBaseCost(){
                        return iBaseCost;
                }
                    public Double getAddedCost(){
                        return iAddedCost;
                    }

                    public Double getTotalCost(){
                        return iTotalCost;
                    }
}
