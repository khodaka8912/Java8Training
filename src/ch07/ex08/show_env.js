var env = java.lang.System.getenv()
for each (e in env.entrySet()) {print(e.key + ' = ' + e.value)}