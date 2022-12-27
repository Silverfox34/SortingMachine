
counter_d = 0

function main()
    local s
    --for s=7, 15 do

        
        local array = getRandomArray(MathPow(2,5))
        local bef = os.time()
        quickSort(array, 0, #array)
        local after = os.time()
        print("TIME: ", after-bef)
        print("Calls on partition(): ", counter_d)
        print("---")
        printArray(array)
        
        counter_d = 0
        print("---------------------------------------")

    --end

end

function quickSort(array, begin_element, end_element) 
    local partitionIndex
    if (begin_element < end_element) 
    then
        partitionIndex = partition(array, begin_element, end_element);
        
        if ((end_element - (partitionIndex+1)) >= (partitionIndex-1)) then
            quickSort(array, begin_element, partitionIndex-1)
            quickSort(array, partitionIndex+1, end_element)
        else
            quickSort(array, partitionIndex+1, end_element)
            quickSort(array, begin_element, partitionIndex-1)
        end


    end 
end

function partition(array, begin_element, end_element)
    counter_d = counter_d + 1
    local i, j, k, mean, tmp, diff, pivot, new_pivot, pivot_value
    local sum = 0
    local temp_array = {}
    local index = 0
    local counter = 0
    
   
 
    for i=begin_element, end_element
    do
        sum = sum + array[i]
        counter = counter + 1
    end
    mean = sum / counter
   

    diff = AbsoluteDifference(mean, array[begin_element])
    pivot = begin_element
    for k=begin_element, end_element
    do
        if (AbsoluteDifference(mean, array[k])<=diff)
        then
            diff = AbsoluteDifference(mean, array[k])
            pivot = k
        end
    end
    
    


    pivot_value = array[pivot]
    new_pivot = pivot 
    
    for i=0, #array
    do
        temp_array[i] = array[i]
    end
    

    for i=begin_element, end_element
    do
        if(array[i] < array[pivot]) then
            temp_array[index+begin_element] = array[i]
            index = index + 1
        end
    end

    for i=begin_element, end_element
    do
        if(array[i] == array[pivot]) then
            temp_array[index+begin_element] = array[i]
            index = index + 1
        end
    end

    for i=begin_element, end_element
    do
        if(array[i] > array[pivot]) then
            temp_array[index+begin_element] = array[i]
            index = index + 1
        end
    end
    

    --print("FROM , TO", begin_element, end_element)
    --print("OLD: ")
    --print(pivot, array[pivot])
    --print("---")
    --printArray(array)
    --print("----------")
   

    for i=begin_element, end_element
    do
        array[i] = temp_array[i]
    end

    for i=begin_element, end_element
    do
        if(temp_array[i] == pivot_value)then
            new_pivot = i          
        end
    end



    temp_array = {}
    
    --print("NEW: ")
    --print(new_pivot, array[new_pivot])
    --print("---")
    --printArray(array)
    --print("----------")
    --print("----------")


    return new_pivot
    
end
    



function printArray(array)
    local i
    for i=0, #array, 1
    do
        print(array[i])
    end
end

function MathPow(number, exponent)
    local erg = number
    local i
    for i = 1, exponent-1, 1
    do
        number = number * erg
    end
    
    return number
end

function Mean(array)
    local i, sum, erg
    sum = 0
    for i=0, #array, 1
    do
        sum = sum + array[i]
    end
    
    erg = sum/(#array+1)

    return erg

end

function AbsoluteDifference(a,b)
    if(a==b)
    then
        return 0
    end

    if(a<b)
    then
        return (b-a)
    else
        return (a-b)
    end

end

function getRandomArray(size)
    math.randomseed(os.time())
    local array = {}
    local i
    for i=0, size-1, 1
    do
        
        array[i] = math.floor(math.random()*1000)
    end

    return array
end

main()