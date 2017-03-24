From Scratch
---

1) Create File > New > Scala Project  
2) Copy XMLDemo.scala file this project  
3) Right Click Project > Build Path > Add External Jars > C:\Spark\jars (Select all jars). In this step we are referencing all the spark jars from spark's jars folder.  
4) Run XmlDemo 

Prerequsite
---
1) Install Spark under C:\ drive with folder name as spark. Download is available on Spark website  
2) On cmd prompt cd c:\spark\bin  
3) Execute command => "spark-shell --packages com.databricks:spark-xml_2.11:0.4.1"   
4) Step 3 will create a jar file in  location C:\Users\bkachalia\.ivy2\jars. Visit URL (https://github.com/databricks/spark-xml) for details
5) Import in build path Spark jars from "c:\spark\jars" into the workspace  
6) Import in build path spark-xml jar (com.databricks_spark-xml_2.11-0.4.1.jar) from location "C:\Users\bkachalia\.ivy2\jars". Remember this jar is created from step 3.


Debugging
---
1) Import spark-xml jar (com.databricks_spark-xml_2.11-0.4.1.jar) to avoid below exception. This jar is created using by prerequisite step-3.   
Exception in thread "main" java.lang.ClassNotFoundException: Failed to find data source: com.databricks.spark.xml. Please find packages at http://spark-packages.org  

2) Set "spark.sql.warehouse.dir" in SparkConf to avoid below URISyntaxException error. Spark will read files from this location.
java.net.URISyntaxException: Relative path in absolute URI: file:C:/brijesh/code/scala/scala_wrksp/Test/spark-warehouse  

3) Make sure all jar are correct referenced in Build Path. Any incompatible jar will cause below error. Check "Problems" tab for any errors
Could not find or load main class  




