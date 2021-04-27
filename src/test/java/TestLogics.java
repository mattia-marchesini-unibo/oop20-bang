import org.junit.Test;

import libs.CircularList;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import model.Logics;
import model.Player;
import model.Role;
import model.SimplePlayer;
import model.SimpleTable;
import model.Table;
import model.card.Card;

public class TestLogics {
	
	 @Test
	 public void testGetTarget() {
		 CircularList<Player> list = new CircularList<Player>();
		 Player p1 = new SimplePlayer(Role.OUTLAW,"ryan");
		 Player p2 = new SimplePlayer(Role.RENEGADE,"davide");
		 Player p3 = new SimplePlayer(Role.OUTLAW, "mattia");
		 Player p4 = new  SimplePlayer(Role.SHERIFF, "giulia");
		 list.add(p4);
		 list.add(p3);
		 list.add(p2);
		 list.add(p1);
		 p3.modifyRetreat(1);
		 p4.setRange(2);
		 Logics l = new Logics(new SimpleTable(null,list));
		 var set = l.getTargets();
		 assertEquals(Set.of(p3,p1,p2), set);
		 //prima tutto con range 1 
		 //poi con retreat
	 }
	 
	 
	 
	
}
