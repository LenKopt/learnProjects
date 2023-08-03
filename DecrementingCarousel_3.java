package com.epam.rd.autotasks;

public class DecrementingCarousel {
    protected int[] array;
    protected int numberItems;
    private CarouselRun carouselRun;

    public DecrementingCarousel(){

    }
    public DecrementingCarousel(int capacity) {
        this.array = new int[capacity];
        this.numberItems = -1;
    }

    public int[] getArray() {
        return array;
    }

    public int getNumberItems() {
        return numberItems;
    }

    public void setNumberItems(int numberItems) {
        this.numberItems = numberItems;
    }

    public boolean addElement(int element) {
        boolean result = false;
        if (this.carouselRun != null) {
            return false;
        }
        if (this.numberItems < this.array.length) {

            if ((element > 0)&&(this.numberItems < (this.getArray().length - 1))) {
                this.array[this.numberItems + 1] = element;
                this.numberItems++;
                result = true;
            }
        }
        return result;
    }

    public void setCarouselRun(CarouselRun carouselRun) {
        this.carouselRun = carouselRun;
    }

    public CarouselRun run() {

        if (this.carouselRun == null) {
            CarouselRun currentCarousel = new CarouselRun(this);
            this.setCarouselRun(currentCarousel);
            return currentCarousel;
        } else {
            return null;
        }
    }
}
