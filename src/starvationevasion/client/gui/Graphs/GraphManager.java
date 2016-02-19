package starvationevasion.client.GUI.Graphs;

import starvationevasion.client.GUI.GUI;
import starvationevasion.common.EnumFood;
import starvationevasion.common.EnumRegion;

/**
 * Graph Manager which handles all of the graphs attached to the GUI
 * Has functions which allows the client to add data to a graph or methods for the graph node in the GUI to get
 * the linechart which needs to be displayed
 */
public class GraphManager
{
  GUI gui;

  Graph[] californiaGraphs;
  Graph[] mountainGraphs;
  Graph[] heartlandGraphs;
  Graph[] northernCresentGraphs;
  Graph[] southeastGraphs;
  Graph[] northernPlainsGraphs;
  Graph[] southernPlainsGraphs;

  Graph[] productBarGraphs = new Graph[12];

  final EnumFood[] PRODUCTS = {EnumFood.CITRUS, EnumFood.FRUIT, EnumFood.NUT, EnumFood.GRAIN, EnumFood.OIL, EnumFood.VEGGIES, EnumFood.SPECIAL,
    EnumFood.FEED, EnumFood.FISH, EnumFood.MEAT, EnumFood.POULTRY, EnumFood.DAIRY};

  /**
   * Constructor for the GraphManger
   * @param gui
   */
  public GraphManager(GUI gui)
  {
    this.gui = gui;

    initializeProductBarGraphs();
    initializeGraphNodeGraphs();
  }

  /**
   * Method which adds a data point to the graphs in the food product bar
   * @param year
   * @param foodPrice
   */
  public void addData(int year, double[] foodPrice)
  {
    int p;
    for (int i = 0; i < 12; ++i)
    {
      p =  (int) foodPrice[i];
      productBarGraphs[i].addDataPoint(year, p);
    }
  }

  public void addData(EnumRegion region, int graphNumber, int year, int dataValue)
  {
    Graph g;

    switch (region)
    {
      case CALIFORNIA:
        g = californiaGraphs[graphNumber];
        g.addDataPoint(year, dataValue);
        break;
      case MOUNTAIN:
        g= mountainGraphs[graphNumber];
        g.addDataPoint(year, dataValue);
        break;
      case HEARTLAND:
        g = heartlandGraphs[graphNumber];
        g.addDataPoint(year, dataValue);
        break;
      case NORTHERN_PLAINS:
        g = northernPlainsGraphs[graphNumber];
        break;
      case SOUTHERN_PLAINS:
        g = southernPlainsGraphs[graphNumber];
        g.addDataPoint(year, dataValue);
        break;
      case NORTHERN_CRESCENT:
        g = northernCresentGraphs[graphNumber];
        g.addDataPoint(year, dataValue);
        break;
      case SOUTHEAST:
        g = southeastGraphs[graphNumber];
        g.addDataPoint(year, dataValue);
        break;
      default:
        break;
    }
  }
  /*
  public void addData(EnumRegion region,  int year, int[] grossIncome, int[] foodProduced, int[] foodConsumed)
  {
    Graph g;

    switch (region)
    {
      case CALIFORNIA:
        g = californiaGraphs[3];
        g.addDataPoint(year, grossIncome, foodProduced, foodConsumed);
        break;
      case MOUNTAIN:
        g= mountainGraphs[3];
        g.addDataPoint(year, grossIncome, foodProduced, foodConsumed);
        break;
      case HEARTLAND:
        g = heartlandGraphs[3];
        g.addDataPoint(year, grossIncome, foodProduced, foodConsumed);
        break;
      case NORTHERN_PLAINS:
        g = northernPlainsGraphs[3];
        g.addDataPoint(year, grossIncome, foodProduced, foodConsumed);
        break;
      case SOUTHERN_PLAINS:
        g = southernPlainsGraphs[3];
        g.addDataPoint(year, grossIncome, foodProduced, foodConsumed);
        break;
      case NORTHERN_CRESCENT:
        g = northernCresentGraphs[3];
        g.addDataPoint(year, grossIncome, foodProduced, foodConsumed);
        break;
      case SOUTHEAST:
        g = southeastGraphs[3];
        g.addDataPoint(year, grossIncome, foodProduced, foodConsumed);
        break;
      default:
        break;
    }
  }*/

  /**
   * Gets the requested graph
   * @param region graph of the region
   * @param number number of the graph you want to get
   * @return
   */
  public Graph getGraphNodeGraph(EnumRegion region, int number)
  {
    Graph g;

    switch (region)
    {
      case CALIFORNIA:
        g = californiaGraphs[number];
        break;
      case MOUNTAIN:
        g= mountainGraphs[number];
        break;
      case HEARTLAND:
        g = heartlandGraphs[number];
        break;
      case NORTHERN_PLAINS:
        g = northernPlainsGraphs[number];
        break;
      case SOUTHERN_PLAINS:
        g = southernPlainsGraphs[number];
        break;
      case NORTHERN_CRESCENT:
        g = northernCresentGraphs[number];
        break;
      case SOUTHEAST:
        g = southeastGraphs[number];
        break;
      default:
        g = null;
        break;
    }
    return g;
  }

  /**
   * Gets the request product bar graph
   * @param i index of the product bar graph you want to get
   * @return
   */
  public Graph getProductBarGraph(int i)
  {
    return productBarGraphs[i];
  }

  private void initializeProductBarGraphs()
  {
    for (int i = 0; i < 12; ++i)
    {
      productBarGraphs[i] = new GraphProductBar(PRODUCTS[i]);
    }
  }

  private void initializeGraphNodeGraphs()
  {
    initCaliGraph();
    initHrtGraph();
    initMntGraph();
    initNPGraph();
    initSPGraph();
    initSEGraph();
    initNCGraph();
  }

  private void initCaliGraph()
  {
    californiaGraphs = new Graph[3];
    californiaGraphs[0] = new GraphPopulation(EnumRegion.CALIFORNIA);
    californiaGraphs[1] = new GraphHDI(EnumRegion.CALIFORNIA);
    californiaGraphs[2] = new GraphFarmingBalance(EnumRegion.CALIFORNIA);
    //californiaGraphs[3] = new GraphProductsDollars(EnumRegion.CALIFORNIA);
  }

  private void initMntGraph()
  {
    mountainGraphs = new Graph[3];
    mountainGraphs[0] = new GraphPopulation(EnumRegion.MOUNTAIN);
    mountainGraphs[1] = new GraphHDI(EnumRegion.MOUNTAIN);
    mountainGraphs[2] = new GraphFarmingBalance(EnumRegion.MOUNTAIN);
    //mountainGraphs[3] = new GraphProductsDollars(EnumRegion.MOUNTAIN);
  }

  private void initHrtGraph()
  {
    heartlandGraphs = new Graph[3];
    heartlandGraphs[0] = new GraphPopulation(EnumRegion.HEARTLAND);
    heartlandGraphs[1] = new GraphHDI(EnumRegion.HEARTLAND);
    heartlandGraphs[2] = new GraphFarmingBalance(EnumRegion.HEARTLAND);
    //heartlandGraphs[3] = new GraphProductsDollars(EnumRegion.HEARTLAND);
  }

  private void initSEGraph()
  {
    southeastGraphs = new Graph[3];
    southeastGraphs[0] = new GraphPopulation(EnumRegion.SOUTHEAST);
    southeastGraphs[1] = new GraphHDI(EnumRegion.SOUTHEAST);
    southeastGraphs[2] = new GraphFarmingBalance(EnumRegion.SOUTHEAST);
    //southeastGraphs[3] = new GraphProductsDollars(EnumRegion.SOUTHEAST);
  }

  private void initSPGraph()
  {
    southernPlainsGraphs = new Graph[3];
    southernPlainsGraphs[0] = new GraphPopulation(EnumRegion.SOUTHERN_PLAINS);
    southernPlainsGraphs[1] = new GraphHDI(EnumRegion.SOUTHERN_PLAINS);
    southernPlainsGraphs[2] = new GraphFarmingBalance(EnumRegion.SOUTHERN_PLAINS);
    //southernPlainsGraphs[3] = new GraphProductsDollars(EnumRegion.SOUTHERN_PLAINS);
  }

  private void initNCGraph()
  {
    northernCresentGraphs = new Graph[3];
    northernCresentGraphs[0] = new GraphPopulation(EnumRegion.NORTHERN_CRESCENT);
    northernCresentGraphs[1] = new GraphHDI(EnumRegion.NORTHERN_CRESCENT);
    northernCresentGraphs[2] = new GraphFarmingBalance(EnumRegion.NORTHERN_CRESCENT);
    //northernCresentGraphs[3] = new GraphProductsDollars(EnumRegion.NORTHERN_CRESCENT);
  }

  private void initNPGraph()
  {
    northernPlainsGraphs = new Graph[3];
    northernPlainsGraphs[0] = new GraphPopulation(EnumRegion.NORTHERN_PLAINS);
    northernPlainsGraphs[1] = new GraphHDI(EnumRegion.NORTHERN_PLAINS);
    northernPlainsGraphs[2] = new GraphFarmingBalance(EnumRegion.NORTHERN_PLAINS);
    //northernPlainsGraphs[3] = new GraphProductsDollars(EnumRegion.NORTHERN_PLAINS);
  }
}
