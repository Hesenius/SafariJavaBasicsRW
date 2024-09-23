package interfaces;

import java.util.ArrayList;
import java.util.List;

// classes can only have a SINGLE parent class
// but can implement MANY interfaces
public sealed interface Photographer permits SpySatellite, ParentWithCamera, ProductionCompany {
  String takePhoto(String s); // IMPLICITLY PUBLIC also ABSTRACT
}

final class SpySatellite implements Photographer {
  public String takePhoto(String subject) {
    return "click click wizz photo of " + subject + " I can read your license plate";
  }
}

non-sealed  class ParentWithCamera implements Photographer {
  public String takePhoto(String subject) {
    return "Smile! click photo of " + subject + " with chocolately smile!";
  }

  public void giveThankYouGift() {
    System.out.println("give parent some cake!");
  }

}

// implicitly final
record ProductionCompany(String name, int price) implements Photographer {
  public String takePhoto(String subject) {
    return "Lights, camera, action; picture of " + subject + " here's a bill for " + price;
  }
}

class UsePhotoTypes {
  public static void main(String[] args) {
//    SpySatellite ss = new SpySatellite();
//    ParentWithCamera pwc = new ParentWithCamera();
    Photographer ss = new SpySatellite();
    Photographer pwc = new ParentWithCamera();
    // could have array of photographer...

    // better mechanism for "many"
//    List<Photographer> photogs = new ArrayList<Photographer>();
//    List<Photographer> photogs = new ArrayList<>();
    List<Photographer> photogs = List.of(ss, pwc); // unmodifiable list
//    photogs.add(ss);
//    photogs.add(pwc);
//    photogs.add("ooops!"); <> syntax allows the compiler to check correct use (Generics)

//    System.out.println(ss.takePhoto("James Bond"));
//    System.out.println(pwc.takePhoto("My kids"));

    for (Photographer p : photogs) {
      if (p instanceof ParentWithCamera friend) { // pattern match with instanceof
        System.out.println(p.takePhoto("My kids"));
        friend.giveThankYouGift();
//      } else {
//        friend // NOPE, friend is not in scope
      }
/*
      if (p instanceof ParentWithCamera) {
        System.out.println(p.takePhoto("My kids"));

        ParentWithCamera friend = (ParentWithCamera) p;
        friend.giveThankYouGift();
      }
*/
      System.out.println(p.takePhoto("James Bond"));
    }
    System.out.println("--------------------");
    for (Photographer p : photogs) {
      switch (p) {
        case ProductionCompany(String pcname, int price) -> {
          System.out.println("prepare for a bill of " + price + " from " + pcname);
        }
        case ParentWithCamera friend -> {
          System.out.println(friend.takePhoto("My kids"));
          friend.giveThankYouGift();
        }
        case SpySatellite sp -> System.out.println(sp.takePhoto("James Bond"));
//        default -> System.out.println("Huh, what kind of photographer");
      }
    }
  }
}