package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {
    public int actionLimit;
    //public  int actionExecut = 0;
    private CorouselRunWithLimit corouselRunWithLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;

    }

    public int getActionLimit() {
        return this.actionLimit;
    }

    @Override
    public CarouselRun run() {
        if (this.corouselRunWithLimit == null) {
            CorouselRunWithLimit currentCarousel = new CorouselRunWithLimit(this);
            this.setCorouselRunWithLimit(currentCarousel);
            return currentCarousel;
        } else {
            return null;
        }
    }

    public void setCorouselRunWithLimit(CorouselRunWithLimit corouselRunWithLimit) {
        this.corouselRunWithLimit = corouselRunWithLimit;
    }

    @Override
    public boolean addElement(int element) {
        boolean result = false;
        if (this.corouselRunWithLimit != null) {
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
}
