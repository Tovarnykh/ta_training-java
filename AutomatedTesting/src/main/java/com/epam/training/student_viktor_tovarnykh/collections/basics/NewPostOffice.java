package com.epam.training.student_viktor_tovarnykh.collections.basics;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewPostOffice {
    private final Collection<Box> listBox;
    private static final int COST_KILOGRAM = 5;
    private static final int COST_CUBIC_METER = 100;
    private static final double COEFFICIENT = 0.5;

    public NewPostOffice() {
        listBox = new ArrayList<>();
    }

    public Collection<Box> getListBox() {
        return (Collection<Box>) ((ArrayList<Box>) listBox).clone();
    }

    static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
        BigDecimal costWeight = BigDecimal.valueOf(weight)
                .multiply(BigDecimal.valueOf(COST_KILOGRAM), MathContext.DECIMAL64);
        BigDecimal costVolume = BigDecimal.valueOf(volume)
                .multiply(BigDecimal.valueOf(COST_CUBIC_METER), MathContext.DECIMAL64);
        return costVolume.add(costWeight)
                .add(BigDecimal.valueOf(COEFFICIENT * value), MathContext.DECIMAL64);
    }

    // implements student
    public boolean addBox(String addresser, String recipient, double weight, double volume, int value) {
        if (addresser == null || recipient == null || recipient.isBlank() || addresser.isBlank()){
            throw new IllegalArgumentException("Values should not be blank or null");
        }

        if(value <= 0 || volume < 0 || volume > 0.25 || volume == 0 || weight < 0.5 || weight > 20.0){
            throw new IllegalArgumentException("Incorrect input data");
        }

        Box box = new Box(addresser, recipient, weight, volume);

        BigDecimal cost = calculateCostOfBox(weight, volume, value);
        box.setCost(cost);

        return listBox.add(box);
    }

    public Collection<Box> deliveryBoxToRecipient(String recipient) {
        Collection<Box> recipientParcels = new ArrayList<>();
        Iterator<Box> iterator = listBox.iterator();

        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (box.getRecipient().equals(recipient)) {
                recipientParcels.add(box);
                iterator.remove();
            }
        }

        return recipientParcels;    }

    public void declineCostOfBox(double percent) {
        for (Box box : listBox) {
            BigDecimal reduction = box.getCost().multiply(BigDecimal.valueOf(percent / 100.0));
            BigDecimal newCost = box.getCost().subtract(reduction).round(MathContext.DECIMAL64);

            box.setCost(newCost);
        }
    }

}
