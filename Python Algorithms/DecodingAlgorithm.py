creditCard = input('Please input credit card information: ')

splitNumbers = [int(a) for a in str(creditCard)]

everyOtherNumber = splitNumbers[::2]
remainingNumbers = splitNumbers[1::2]

def doublingRemainingNumbersFunction(remainingNumbers):
    doubledRemainingNumbers = []
    for x in remainingNumbers:
        x = x * 2
        doubledRemainingNumbers.append(x)
    return doubledRemainingNumbers


def doublingFunction(array):
    doubledNumbers = []
    for x in array:
        x = x * 2
        doubledNumbers.append(x)
    return doubledNumbers


def checkDoubledNumbers(array):
    summedNumbers = []
    for x in array:
        if x >= 10:
            summedNumbers.append(x)

    return summedNumbers

# finalArray
def sumDoubledNumbers(doubledNumbersArray):
    summedDoubledNumbers = []
    for x in doubledNumbersArray:
        newNr = [int(a) for a in str(x)]
        Sum = sum(newNr)
        summedDoubledNumbers.append(Sum)
    return summedDoubledNumbers


def sumAllNumbersAndCheckValidity(finalArray, remainingNumbersArray):
    Summables = []

    for x in finalArray:
        Summables.append(x)

    for x in remainingNumbersArray:
        Summables.append(x)

    SummedUp = sum(Summables)
    print(SummedUp)
    FinalValidationCharacter = [int(a) for a in str(SummedUp)]

    if(FinalValidationCharacter[1] == 0):
        print("Card is valid!")
        print(FinalValidationCharacter)
    else:
        print("Card is invalid!")
        print(FinalValidationCharacter)



sumAllNumbersAndCheckValidity(sumDoubledNumbers(checkDoubledNumbers(doublingFunction(everyOtherNumber))), doublingRemainingNumbersFunction(remainingNumbers))
# print(sumDoubledNumbers(checkDoubledNumbers(doublingFunction(everyOtherNumber))))
# print(sumDoubledNumbers(checkDoubledNumbers(doublingFunction(everyOtherNumber))))
# print(doublingRemainingNumbersFunction(remainingNumbers))


# 4137894711755904




