package model;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberComboBoxListModel extends NumberListModel implements ComboBoxModel<BigDecimal> {
    // index of current selected item
    private int selectedId;

    public NumberComboBoxListModel(BigDecimal start, BigDecimal end, BigDecimal step) {
        super(start, end, step);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof BigDecimal) {
            BigDecimal curr = (BigDecimal) anItem;
            selectedId = curr.subtract(super.start).divide(super.step, RoundingMode.HALF_DOWN).intValue();
        }
    }

    @Override
    public Object getSelectedItem() {
        BigDecimal item = new BigDecimal(selectedId).multiply(super.step).add(super.start).setScale(1, RoundingMode.HALF_DOWN);
        return item;
    }
}
