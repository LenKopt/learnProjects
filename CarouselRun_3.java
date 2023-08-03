package com.epam.rd.autotasks;

public class CarouselRun {

    protected DecrementingCarousel owner;
    protected int count;

    CarouselRun(){

    }
    CarouselRun(DecrementingCarousel owner) {
        this.owner = owner;
        this.count = 0;
    }

    public int next() {

        int result = -1;
        int[] array = this.owner.getArray();
        int numberItems = owner.getNumberItems();

        if (numberItems != -1) {
            while (array[numberItems] == 0) {
                numberItems--;
                owner.setNumberItems(numberItems);
                if (numberItems==-1){
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
        return result;
    }

    public int check() {

        int result = -1;
        //System.out.println(this.owner.equals(null));

        int[] array = this.owner.getArray();

        for (int item : array) {
            if (item != 0) {
                result = 1;
            }
        }
        return result;
    }

    public boolean isFinished() {
        boolean result = false;
        if (check() == -1) {
            result = true;
        }
        return result;
    }


}
