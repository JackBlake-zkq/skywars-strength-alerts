package com.zkq.SkyWarsKillAlert;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class Message {

	private static String[] killMessages = {
/*Default*/	"was killed by","was thrown into the void by","was thrown off a cliff by","was shot by",
/*Fire*/	"was struck down by","was turned to dust by","was turned to ash by","was melted by",
/*Western*/	"was filled full of lead by","met their end by","lost a drinking contest with","lost the draw to",
/*Love*/	"was given the cold shoulder by","was out of the league of","heart was broken by","was struck with Cupid's arrow by",
/*Pirate*/	"be sent to Davy Jones' locker by","be cannonballed to death by","be voodooed by","be shot and killed by",
/*Galactic*/"was turned into space dust by","was sent into orbit by","was retrograded by","was hit by an asteroid from",
/*Computer*/"was deleted by","was ALT+F4'd by","was crashed by","was rm -rf by",
/*Flex|*/	"became victim #","was void victim #","was bow kill #",
/*Honor*/	"died in close combat to","fought to the edge with","stumbled off a ledge with help by","fell to the great marksmanship of",
/*BBQ*/		"was glazed in BBQ sauce by","slipped in BBQ sauce off the edge spilled by","was not spicy enough for","was thrown chili powder at by",
/*Insect*/	"was exterminated by","was scared off an edge by","was squashed by","was tranquilized by",
/*Banana|*/	"was mushed by","was peeled by","slipped on","got banana pistol'd by",
/*Boxing*/	"was socked by","was KO'd by","took an uppercut from","was sent into a daze by",
/*Squeak*/	"was chewed up by","was squeaked off the edge by","was distracted by a rat dragging pizza from","was squeaked from a distance by",
/*Oink*/	"was oinked by","slipped into void for","was distracted by a piglet from","got attacked by a carrot from",
/*Buzz*/	"was buzzed to death by","was bzzz'd off the edge by","was stung by","was startled from a distance by",
/*Medieval*/"was crusaded by the knight","was jousted by","was catapulted by","was shot to the knee by",
/*WOOF*/	"was bit by","got WOOF'D by","was growled off an edge by","was thrown a frisbee by",
/*Memed*/	"got rekt by","took the L to","got dabbed on by","got bamboozled by",
/*Snow*/	"was locked outside during a snow storm by","was shoved down an icy slope by","was made into a snowman by","was hit with a snowball from",
/*Evil*/	"was backstabbed by","was pushed into the abyss by","was thrown into a ravine by","was brutally shot by",
/*Eggy*/	"was painted pretty by","was flipped off the edge by","was deviled by","was made sunny side up by",
/*Celeb*/	"whacked with a party balloon by","popped into the void by","was launched like a firework by","shot with a roman candle by",
/*wrapped*/	"wrapped up by","tied into a bow by","tripped over a present placed by","glued up by",
/*xmas*/	"was put on the naughty list by","was pushed down the chimney by","was traded in for milk and cookies by","was turned to gingerbread by"
};
	
	private String text;
	private String msg;
	
	public Message(String s) {
		text = s;
		if(this.isKill()) {
			for (String killMsg : killMessages) {
	        	if(text.contains(killMsg)) msg = killMsg;
	        }	
		}
	}
	
	public boolean isKill() {
        for (String killMsg : killMessages) {
        	if(text.contains(killMsg)) return true;
        }
        return false;
	}
	
	//only will be used if isKill is true
	public String getPlayer() {
		if(msg.equals("became victim #") || msg.equals("was void victim #") || msg.equals("was bow kill #")) {
			return text.substring(text.indexOf("of ")+3, text.length()-1);
		}
		else if(msg.equals("slipped on")) {
			return text.substring(text.indexOf(msg)+msg.length()+1, text.indexOf("banana")-3);
		}
		else if(msg.equals("got WOOF'D by")) {
			return text.substring(text.indexOf(msg)+msg.length()+1, text.indexOf("into the void.")-1);
		}
		else {
			return text.substring(text.indexOf(msg)+msg.length()+1, text.length()-1);
		}
	}
}
