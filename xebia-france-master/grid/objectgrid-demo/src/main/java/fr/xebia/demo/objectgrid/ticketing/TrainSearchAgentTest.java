/*
 * Copyright 2002-2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.xebia.demo.objectgrid.ticketing;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import com.ibm.websphere.objectgrid.ObjectMap;
import com.ibm.websphere.objectgrid.Session;
import com.ibm.websphere.objectgrid.datagrid.AgentManager;

import fr.xebia.demo.objectgrid.ticketing.test.AbstractTicketingGridTest;

/**
 * @author <a href="mailto:cyrille.leclerc@pobox.com">Cyrille Le Clerc</a>
 */
public class TrainSearchAgentTest extends AbstractTicketingGridTest {
    
    private final static Logger logger = Logger.getLogger(TrainSearchAgentTest.class);
    
    public void test() throws Exception {
        
        Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
        Date noonToday = DateUtils.addHours(today, 12);
        
        TrainSearchAgent trainSearchAgent = new TrainSearchAgent(PARIS_GARE_DE_LYON, noonToday, MARSEILLE_SAINT_CHARLES);
        
        Session session = objectGrid.getSession();
        ObjectMap employeeMap = session.getMap("Train");
        AgentManager agentManager = employeeMap.getAgentManager();
        
        List<RouteDetails> matchingTrainsByPartionId = (List<RouteDetails>)agentManager.callReduceAgent(trainSearchAgent);
        logger.debug(matchingTrainsByPartionId.size() + " matching trains found ");
        
        for (RouteDetails routeDetails : matchingTrainsByPartionId) {
            logger.debug(routeDetails);
        }
    }
}
