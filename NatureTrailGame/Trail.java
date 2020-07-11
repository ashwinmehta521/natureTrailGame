
/**
 * Write a description of class Trail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Trail
{
    NatureFeature[] features;
    
    public Trail()
    {
        features = new NatureFeature[4];
        
    }
    
    public Trail(int size)
    {
        features = new NatureFeature[size];
        
    }
    
    public NatureFeature getFeature(int index)
    {
        return features[index];
    }
    
    public void setFeature(int index,int newFeaturePosition,String newFeatureType,int newSpacePenalty)
    {
        features[index].setFeaturePosition(newFeaturePosition);
        features[index].setFeatureType(newFeatureType);
        features[index].setSpacePenalty(newSpacePenalty);
    }
    
    public void setupFeatures()
    {
        features[0] = new NatureFeature(0,"Creek",-2);
        features[1] = new NatureFeature(0,"Bridge",+4);
        features[2] = new NatureFeature(0,"Fallen Tree",-3);
        features[3] = new NatureFeature(0,"Landslide",-5);
    }
}
