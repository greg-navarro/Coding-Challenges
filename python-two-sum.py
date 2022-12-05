class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        listLength = len(nums)
        if listLength < 2: return [-1, -1]
        # establish indicies 
        left = 0
        right = 1
        # loop through nums until target is found (as per assumption)
        while left < listLength:
            # check for success
            if nums[left] + nums[right] == target:
                return [left, right]
            # check if right can be increased
            # else increase left and set right to left + 1
            if right < listLength - 1:
                right += 1
            else: 
                left += 1
                right = left + 1
                if right >= listLength:
                    return [-1, -1]
