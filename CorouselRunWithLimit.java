package com.epam.rd.autotasks;

public class CorouselRunWithLimit extends CarouselRun{
    public  int actionExecut = 0;
    protected DecrementingCarouselWithLimitedRun owner;
    public CorouselRunWithLimit(DecrementingCarouselWithLimitedRun owner) {
        super(owner);
        this.owner = owner;
    }

    @Override
    public int next() {
        int result = -1;

        if (actionExecut >= this.owner.actionLimit){
            return result;
        }

        int[] array = this.owner.getArray();
        int numberItems = owner.getNumberItems();

        if (numberItems != -1) {
            while (array[numberItems] == 0) {
                numberItems--;
                owner.setNumberItems(numberItems);
                if (numberItems == -1) {
                    break;
                }
            }
        }
        if ((count > 0) && (count > (numberItems))) {
            count = 0;
        }
        for (int i = count; i <= numberItems; i++) {

            if (array[i] == 0) {
                count++;
                continue;
            }
            result = array[i];
            array[i]--;
            count++;
            break;
        }
        /*if (count > this.owner.numberItems) {
            setElementDelta(this.elementDelta + 1);
        }*/
        actionExecut++;
        return result;
    }

    @Override
    public boolean isFinished() {
        boolean result = false;
        if (actionExecut==owner.actionLimit){
            return true;
        }
        if (check() == -1) {
            result = true;
        }
        return result;
    }
}
