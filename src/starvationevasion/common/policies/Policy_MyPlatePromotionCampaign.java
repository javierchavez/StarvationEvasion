package starvationevasion.common.policies;

import java.util.ArrayList;

/**
 * Title: {@value #TITLE}<br><br>
 * Game Text: {@value #TEXT}<br><br>
 *
 * Draft Affects: When drafting this policy, player selects X million dollars.<br><br>
 *
 * Votes Required: Automatic <br><br>
 *
 * Model Effects: Model uses four control points of an ease-in-out cubic Bezier
 * function giving shift in food preference demand verses advertising dollars
 * spent. The effect is largest in the region running the campaign, but also
 * effects world regions in direct proportion to that regions import levels of the
 * effected food categories.
*/
public class Policy_MyPlatePromotionCampaign extends PolicyCard
{
  public static final String TITLE =
     "MyPlate Promotion Campaign";

  public static final String TEXT =
     "You spend X million dollars on an advertising campaign within your region promoting " +
     "public awareness of the United States Department of Agriculture's MyPlate nutrition guide.";



  /**
   * {@inheritDoc}
  */
  @Override
  public String getTitle(){ return TITLE;}

  /**
   * {@inheritDoc}
  */
  @Override
  public String getGameText(){ return TEXT;}

  /**
   * Millions of dollars spent.
   * {@inheritDoc}
   */
  @Override
  public ArrayList<Integer> getOptionsOfVariable()
  {
    ArrayList<Integer> options=new ArrayList<>();
    options.add(5);
    options.add(10);
    options.add(15);
    return options;
  }
}