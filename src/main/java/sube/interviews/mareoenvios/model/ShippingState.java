package sube.interviews.mareoenvios.model;

public enum ShippingState {
    initial,
    sendToMail,
    inTravel,
    delivered,
    cancelled;

    public static ShippingState fromString(String transition) {
        for (ShippingState state : values()) {
            if (state.name().equalsIgnoreCase(transition)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Invalid transition: " + transition);
    }

    public boolean canTranstionTo(ShippingState newState){
        if(this == delivered || this == cancelled) {
            return false;
        } else if (this == initial) {
            return newState == sendToMail  || newState == cancelled;
        } else if ( this == sendToMail ){
            return newState == inTravel  || newState == cancelled;
        } else if ( this == inTravel ) {
            return newState == delivered;
        } else return false;
    }
}
