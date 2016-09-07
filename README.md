PrettyNumbers
=============

A Java library that formats numbers to abbreviated form. E.g format the file size 50.000 as 50 Kb 

#### Examples
```Java
PrettyFormat pretty = new PrettyFormat();

/* Specifies how many fractions to use */
pretty.setFractionDigits(2);
```

#### Example, file size
```Java
/* Formats number in Kilo byte sizes */
pretty.setUnit(ByteUnit.Kb);
System.out.println(pretty.format("1234")); // outputs 1.20 Kb

/* Formats number in Mega byte sizes */
pretty.setUnit(ByteUnit.Mb);
System.out.println(pretty.format("256000")); // outputs 0.24 Mb
```
#### Example, find best suitable format
```Java
/* Finds the best suitable format for this size of number */
/* Million is found because number is higher than one million and less */
/* than a billion */
pretty.setUnit(ByteUnit.getPreferredUnit(new BigDecimal("1234567"))); // finds Mb
System.out.println(pretty.format("1234567")); // 1.17 Mb
```
#### Example, decimal format
```Java
      // Thousandths , Two decimal places ,Removed at the end of zero
PrettyFormat.with()
    .setUnit(new DecimalUnit(DecimalUnit.DecimalOptions.THOUSAND, "km"))
        .setFractionDigits(2).formatRemoveLastZero("200");//0.2 km
```
