
library(readr)
library(ggplot2)
BoroughEducation <- read.csv("BoroughEducation.csv")
class(BoroughEducation)
row1 = 1
row35 = 35
dataSet = BoroughEducation[row1:row35, 1:6]
class(dataSet)

#Data for individual boroughs
brooklyn <- dataSet[1:7,3:6]
bronx <- dataSet[8:14,3:6]
manhattan <- dataSet[15:21, 3:6]
queens <- dataSet[22:28,3:6]
statenIsland <- dataSet[29:35,3:6]

brookNumeric <- as.numeric(brooklyn[,4])
bronxNumeric <- as.numeric(bronx[,4])
manhattanNumeric <- as.numeric(manhattan[,4])
queensNumeric <- as.numeric(queens[,4])
statenNumeric <- as.numeric(statenIsland[,4]) 

print(dataSet)
avgGraduationRate <- c(mean(brookNumeric), mean(bronxNumeric), mean(manhattanNumeric), mean(queensNumeric), mean(statenNumeric))
names <- c("Brooklyn", "Bronx", "Manhattan", "Queens", "Staten Island")

averageGraduationRateNYC <-data.frame(names, avgGraduationRate)

print(averageGraduationRateNYC)
growthGrad <- function(x){
  previousYear <- x[1]
  years <- x
  z <- numeric()
  for(i in x[2:6]){
    y <- i - previousYear
    z <- c(z, y)
    previousYear = i
  }
  averageGrowth = mean(z)
  return(averageGrowth)
}

brooklynGrad = brooklyn[,4]
bronxGrad = bronx[,4]
manhattanGrad = manhattan[,4]
queensGrad = queens[,4]
statenIslandGrad = statenIsland[,4]

#data for individual questions
manhattanG <- growthGrad(manhattanGrad)
queensG <- growthGrad(queensGrad)
bronxG <- growthGrad(bronxGrad)
brooklynG <- growthGrad(brooklynGrad)
statenG<- growthGrad(statenIslandGrad)

gradGrowth <- c(manhattanG, queensG, bronxG, brooklynG, statenG)
boroughNames <- c("Manhattan", "Queens", "Bronx", "Brooklyn", "Staten Island")
gradData <- data.frame(boroughNames, gradGrowth)

g = ggplot(gradData, aes(x = boroughNames, y = gradGrowth)) + geom_bar(stat = "identity", fill="#6eadc4", colour="black")
g











