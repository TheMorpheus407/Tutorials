#ifndef VEKTOR_H
#define VEKTOR_H

class Vektor
{
public:
  static int dimension;
  double x,y,z;
  Vektor(double a, double b, double c);
  Vektor operator +(Vektor &b);
  void printMe();
};
#endif
