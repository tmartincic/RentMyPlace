public class FeatureProperty
{
    public int propertyId;
    public int featureId;

    public FeatureProperty() {
        this.propertyId = -1;
        this.featureId = -1;
    }

    public FeatureProperty(int propertyId, int featureId) {
        this.propertyId = propertyId;
        this.featureId = featureId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }
}