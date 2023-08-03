package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    private HalvingCarouselRun halvingCarouselRun;

    public HalvingCarousel(final int capacity) {
        super(capacity);

    }

    public void setHalvingCarouselRun(HalvingCarouselRun halvingCarouselRun) {
        this.halvingCarouselRun = halvingCarouselRun;
    }

    @Override
    public HalvingCarouselRun run() {

        if (this.halvingCarouselRun == null) {
            HalvingCarouselRun halvingCarouselRun = new HalvingCarouselRun(this);
            this.setHalvingCarouselRun(halvingCarouselRun);
            return halvingCarouselRun;
        } else {
            return null;
        }
    }

    @Override
    public boolean addElement(int element) {
        boolean result = false;
        if (this.halvingCarouselRun != null) {
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
