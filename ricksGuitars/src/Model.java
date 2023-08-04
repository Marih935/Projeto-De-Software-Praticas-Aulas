public enum Model {
    LESPAUL, STRATOCASTER, TELECASTER, SG, FLYING_V, EXPLORER, ANY;
    
    public String toString() {
        switch(this) {
            case LESPAUL: return "Les Paul";
            case STRATOCASTER: return "Stratocaster";
            case TELECASTER: return "Telecaster";
            case SG: return "SG";
            case FLYING_V: return "Flying V";
            case EXPLORER: return "Explorer";
            default: return "Unspecified";
        }
    }
}
