

#install.packages("ggplot2")
#install.packages("RColorBrewer")
#install.packages("gridExtra")

library(ggplot2)
library(scales)
library(grid)
library(RColorBrewer)
library(dplyr)
library(gridExtra)

df_output<- read.csv("E:/Big Data/project related/Final stuff/sentimental_output.csv")

df_output <- filter(df_output, Points!= 0)

top20<-arrange(df_output,desc(Points))
top20 <- top20[1:20,]
top20

worst20<- arrange(df_output, (Points))
worst20 <- worst20[1:20,]
worst20

p1<-ggplot(data = top20, aes(x=reorder(Business_Name, Points),y= Points)) + theme_dark()+geom_bar(stat="identity",fill="#c0392b", alpha="0.75") +
  coord_flip() + geom_text(aes(label=Points),hjust=1,color="white") +
  labs(y="Senimental Points per Buisness", x="Business", title="Top 20")+
  geom_hline(yintercept=0, size=0.4, color="black")

p2<-ggplot(data = worst20, aes(x=reorder(Business_Name, -Points),y= Points)) + theme_dark()+geom_bar(stat="identity",fill="#c0392b", alpha="0.75") +
  coord_flip() + geom_text(aes(label=Points),hjust=1,color="white") +
  labs(y="Senimental Points per Buisness", x="Business", title="Worst 20")+
  geom_hline(yintercept=0, size=0.4, color="black")

grid.arrange(p1,p2, ncol=2, top="Sentimental Anaylsis")

g<- arrangeGrob(p1,p2, ncol=2)
ggsave(file="SentimentalAnalysis.png",g, width=13)




