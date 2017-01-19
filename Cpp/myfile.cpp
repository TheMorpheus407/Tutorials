#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

class Tier{
public:
  virtual void wieMachtDasTier(){
    std::cout << "hello" << std::endl;
  }
    virtual void lead(){
      std::cout << "follow me, please" << std::endl;
    }
};
class Blindenfuehrer{
public:
  virtual void lead(){
    std::cout << "follow me." << std::endl;
  }
};
class Hund: public Tier, public Blindenfuehrer{
private:
  string name;
public:
  Hund(string newname):name(newname){}
  void wieMachtDasTier(){
    std::cout << "wuff" << std::endl;
  }
  string getName(){
    return this->name;
  }
  void test(){
    wieMachtDasTier();
  }
  void lead() {
    Blindenfuehrer::lead();
  }
};

int main() {
  Hund ace("ace");
  ace.lead();
  return 0;
}
