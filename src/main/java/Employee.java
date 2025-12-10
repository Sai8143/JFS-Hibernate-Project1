

public class Employee {
 private int eid;
 private String ename;
 private double esal;
 private String desig;

 public Employee() {
  super();
  // TODO Auto-generated constructor stub
 }

 public Employee(int eid, String ename, double esal, String desig) {
  super();
  this.eid = eid;
  this.ename = ename;
  this.esal = esal;
  this.desig = desig;
 }

 public int getEid() {
  return eid;
 }

 public void setEid(int eid) {
  this.eid = eid;
 }

 public String getEname() {
  return ename;
 }

 public void setEname(String ename) {
  this.ename = ename;
 }

 public double getEsal() {
  return esal;
 }

 public void setEsal(double esal) {
  this.esal = esal;
 }

 public String getDesig() {
  return desig;
 }

 public void setDesig(String desig) {
  this.desig = desig;
 }

 @Override
 public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((desig == null) ? 0 : desig.hashCode());
  result = prime * result + eid;
  result = prime * result + ((ename == null) ? 0 : ename.hashCode());
  long temp;
  temp = Double.doubleToLongBits(esal);
  result = prime * result + (int) (temp ^ (temp >>> 32));
  return result;
 }

 @Override
 public boolean equals(Object obj) {
  if (this == obj)
   return true;
  if (obj == null)
   return false;
  if (getClass() != obj.getClass())
   return false;
  Employee other = (Employee) obj;
  if (desig == null) {
   if (other.desig != null)
    return false;
  } else if (!desig.equals(other.desig))
   return false;
  if (eid != other.eid)
   return false;
  if (ename == null) {
   if (other.ename != null)
    return false;
  } else if (!ename.equals(other.ename))
   return false;
  if (Double.doubleToLongBits(esal) != Double.doubleToLongBits(other.esal))
   return false;
  return true;
 }

 @Override
 public String toString() {
  return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", desig=" + desig + "]";
 }

}