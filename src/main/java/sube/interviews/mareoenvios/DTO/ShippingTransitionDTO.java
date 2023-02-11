package sube.interviews.mareoenvios.DTO;

public class ShippingTransitionDTO {
    private String transition;

    public ShippingTransitionDTO (){}

    public ShippingTransitionDTO(String transition){
        this.transition = transition;
    }

    public String getTransition() {
        return transition;
    }

    public void setTransition(String transition) {
        this.transition = transition;
    }
}