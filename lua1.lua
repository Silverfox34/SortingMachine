
counter_d = 0

function main()
    
    local array = getRandomArray(MathPow(2,18))
    local bef = os.time()
    quickSort(array, 0, #array)
    local after = os.time()
    print("TIME: ", after-bef)
    --printArray(array)
    --print("Calls on partition(): ", counter_d)


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
    local counter = 0
    local sum = 0
    local index = begin_element - 1
    
    local i, k, pivot, diff, mean, pivot_val, new_pivot
    local new_pivot = begin_element
   
 
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


    
    pivot_val = array[pivot]
    swap(array, pivot, end_element)

    
    for j=begin_element, end_element, 1
    do
        new_pivot = end_element
        if(array[j] <= pivot_val)
        then
            index  = index + 1
            swap(array, index, j)
            new_pivot = index
            
        end
    end

    return new_pivot;
    
    
end


function swap(array, pos1, pos2)
    local tmp = array[pos1]
    array[pos1] = array[pos2]
    array[pos2] = tmp

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