var pipe = function() {var v; for(var i = 0; i < arguments.length; i++) {v = $EXEC(arguments[i], v)} return v}
print(pipe('ls -al', 'grep txt', 'sort'))
