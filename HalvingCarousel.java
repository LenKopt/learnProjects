package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel{
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
}
