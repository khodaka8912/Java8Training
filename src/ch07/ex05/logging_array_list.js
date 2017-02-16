var newLoggingArray = function() {var arr = new (Java.extend(java.util.ArrayList)) {add: function(x) {print('Adding ' + x); return Java.super(arr).add(x)}}; return arr;}
var arr1 = newLoggingArray()
print(arr1.getClass())
arr1.add('item1')
arr1.add('item2')
var arr2 = newLoggingArray()
print(arr2.getClass())
arr2.add('item3')
arr2.add('item4')
