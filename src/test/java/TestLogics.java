import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import libs.CircularList;

import model.Logics;
import model.Player;
import model.Role;
import model.SimplePlayer;
import model.SimpleTable;

public class TestLogics {
        
         @Test
         public void testGetTarget() {
             CircularList<Player> list = new CircularList<Player>();
             Player p1 = new SimplePlayer(Role.OUTLAW,"p1");
             Player p2 = new SimplePlayer(Role.RENEGADE,"p2");
             Player p3 = new SimplePlayer(Role.OUTLAW, "p3");
             Player p4 = new  SimplePlayer(Role.SHERIFF, "p4");
             list.add(p4);
             list.add(p3);
             list.add(p2);
             list.add(p1);
             
             p4.setRange(1);
             var table = new SimpleTable(null,list);
             Logics l = new Logics(table);
             var set1 = l.getTargets();
             assertEquals(Set.of(p3,p1), set1);
             
             p3.modifyRetreat(1);
             p4.setRange(2);
             var set2 = l.getTargets();
             assertEquals(Set.of(p3,p1,p2), set2);
             
             p4.setRange(1);
             p3.modifyRetreat(1);
             p1.modifyRetreat(1);
             var set3 = l.getTargets();
             assertEquals(Set.of(), set3);
         }
         
}