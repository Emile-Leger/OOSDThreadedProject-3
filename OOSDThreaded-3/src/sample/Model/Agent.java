package sample.Model;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Emile on 3/7/16.
 */
public class Agent
{

    public static final String TableName = "agents";

    /*
     * constructor with each field provided
     * */
    public Agent(int agentId, String agtFirstName, String agtMiddleInitial, String agtLastName,
                 String agtBusPhone, String agtEmail, String agtPosition, int agencyId)
    {
        this.AgentId = agentId;
        this.AgtFirstName = agtFirstName;
        this.AgtLastName = agtLastName;
        this.AgtMiddleInitial = agtMiddleInitial;
        this.AgtBusPhone = agtBusPhone;
        this.AgtEmail = agtEmail;
        this.AgtPosition = agtPosition;
        this.AgencyId = agencyId;
    }
    public Agent() { }

    /*
    * Agent Properties, with Get Set methods
    * */

    public static Agent getById(int AgentId)
    {
        HashMap join = new HashMap();
        join.put("AgentId",AgentId);
        Factory factory = new Factory(Agent.class);
        factory.getSelectWhere(join);
        Agent agent = (Agent) factory.makeEntity().firstElement();
        return agent;
    }

    public static Vector<Agent> getAll()
    {
        Factory factory = new Factory(Agent.class);
        factory.getSelectAll();
        Vector agents = factory.makeEntity();
        return agents;
    }

    private int AgentId;
    public void setAgentId(int agentId) { AgentId = agentId; }
    public int getAgentId() { return AgentId; }

    private String AgtFirstName;
    public String getAgtFirstName() { return AgtFirstName; }
    public void setAgtFirstName(String agtFirstName) { AgtFirstName = agtFirstName; }

    private String AgtMiddleInitial;
    public String getAgtMiddleInitial() { return AgtMiddleInitial; }
    public void setAgtMiddleInitial(String agtMiddleInitial) { AgtMiddleInitial = agtMiddleInitial; }

    private String AgtLastName;
    public String getAgtLastName() { return AgtLastName; }
    public void setAgtLastName(String agtLastName) { AgtLastName = agtLastName; }

    private String AgtBusPhone;
    public String getAgtBusPhone() { return AgtBusPhone; }
    public void setAgtBusPhone(String agtBusPhone) { AgtBusPhone = agtBusPhone; }


    private String AgtEmail;
    public String getAgtEmail() { return AgtEmail; }
    public void setAgtEmail(String agtEmail) { AgtEmail = agtEmail; }

    private String AgtPosition;
    public String getAgtPosition() { return AgtPosition; }
    public void setAgtPosition(String agtPosition) { AgtPosition = agtPosition; }

    private int AgencyId;
    public int getAgencyId() { return AgencyId; }
    public void setAgencyId(int agencyId) { AgencyId = agencyId; }

}