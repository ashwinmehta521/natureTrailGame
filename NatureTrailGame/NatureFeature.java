
/**
 * Stores information about a nature feature
 * provides accessor and mutator methods for featurePosition, featureType and spacePenalty
 * @author (Ashwin Ashok Mehta)
 * @version (05/04/2019)
 */
public class NatureFeature
{   
    private int featurePosition;
    private String featureType;
    private int spacePenalty;

    /**
     * NatureFeature Default Constructor
     * initializes the fields to the default values
     */
    public NatureFeature()
    {
        featurePosition = 0;
        featureType = "";
        spacePenalty = 0;
    }
    
    /**
     * NatureFeature Non-Default Constructor
     * initializes fields to the assigned values
     * @param newFeaturePosition a formal parameter of integer type
     * @param newFeatureType a formal parameter of String type
     * @param newSpacePenalty a formal parameter of integer type
     */
    public NatureFeature(int newFeaturePosition, String newFeatureType, int newSpacePenalty)
    {
        featurePosition = newFeaturePosition;
        featureType = newFeatureType;
        spacePenalty = newSpacePenalty;
    }
    
    /**
     * Method displayFeature
     * To display the current state of a nature feature
     * @return the current state of nature feature in the string format
     */
    public String displayFeature()
    {
        String output = featurePosition + " " + featureType + " " + spacePenalty;
        return output;
    }
    
    /**
     * Method getFeaturePosition
     * To get the value of position field of the NatureFeature class
     * @return it returns the position as a integer
     */
    public int getFeaturePosition()
    {
        return featurePosition;
    }
    
    public String getFeatureType()
    {
        return featureType;
    }
    
    public int getSpacePenalty()
    {
        return spacePenalty;
    }
    
    public void setFeaturePosition(int newFeaturePosition)
    {
        if (newFeaturePosition >= 0)
        {
            featurePosition = newFeaturePosition;
        }       
    }
    
    public void setFeatureType(String newFeatureType)
    {
        featureType = newFeatureType;
    }
    
    public void setSpacePenalty(int newSpacePenalty)
    {
        spacePenalty = newSpacePenalty;
    }
    

    
    
}
