
package mevsmonster;

import java.util.Random;
import java.util.*;

/**
 *
 * @author rajendra
 */
public class Mevsmonster {

  
    int health;
    int attack;
    int defence;
    int damage;
    Mevsmonster(int health,int attack,int defence,int damage){
        this.health=health;
        this.attack=attack;
        this.defence=defence;
        this.damage=damage;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Random rand=new Random();
        Scanner sc=new Scanner(System.in);
        
        String monsterName;
        Mevsmonster person=new Mevsmonster(rand.nextInt(70)+10,rand.nextInt(5)+3,
        rand.nextInt(8)+3,rand.nextInt(5)+2);
        for(int i=0;i<3;i++){
            int num = rand.nextInt(5);
            switch (num) {
                case 0: monsterName = "Black Daemon"; break;
                case 1: monsterName = "The Rabbit"; break;
                case 2: monsterName = "Silver Dragon"; break;
                case 3: monsterName = "Mountain Troll"; break;
                case 4: monsterName = "Alien"; break;
                default: monsterName = "Sphinx"; break;
            }
            Mevsmonster monster=new Mevsmonster(rand.nextInt(20)+8,rand.nextInt(4)+2,
            rand.nextInt(6)+3,rand.nextInt(4)+2);
            boolean runaway=false;
            do{
                boolean attacker = rand.nextBoolean();
                if(attacker){
                    System.out.println("You attack");
                    int dice = rand.nextInt(6)+1 + rand.nextInt(6)+1;
                    int attackValue = person.attack + dice;
                    System.out.println("Rolled values: "+dice);
                    System.out.println("Your attack value: " + attackValue);
                    if (attackValue > monster.defence) {
                        System.out.println("Your attack was successful.");
                        monster.health = monster.health - person.damage;
                        System.out.println(monsterName+"'s remaining Life Points: " + monster.health);
                    } else {
                        System.out.println("Your attack was not successful.");
                    }
                }
                else {
                    System.out.println(monsterName+" attacks.");
                    int dice = rand.nextInt(6)+1 + rand.nextInt(6)+1;
                    int attackValue = monster.attack + dice;
                    System.out.println("Rolled values:"+dice);
                    System.out.println(monsterName+"'s attack value: " + attackValue);
                    if (attackValue > person.defence) {
                        System.out.println(monsterName+"'s attack was successful.");
                        person.health = person.health - monster.damage;
                        System.out.println("Your remaining Life Points: " + person.health);
                    } else {
                        System.out.println(monsterName+"'s attack was not successful.");
                    }
            }
                    System.out.println("Please press ENTER! (Or type in 'run' to run away)");
                String command = sc.nextLine();
                switch (command) {
                    case "run":
                        System.out.println("You ran away. You coward! -4 Life Points!");
                        person.health -= 4;
                        runaway = true;
                        break;
                    default:
                }
            }while(person.health>0 && monster.health >0 && !runaway);
            if (person.health <= 0) {
                System.out.println("You are dead. Your advanture finishes here. R.I.P.");
                break; 
            }
            if (monster.health <= 0) {
                System.out.println("You defeated the "+monsterName+". Congratulations!");
            }
        }
    }
    
}
