# 1
FROM clojure
# 2
LABEL maintainer="Divyum Rastogi"
# 3
COPY . /usr/src/app
# 4                                 
WORKDIR /usr/src/app                                 
# 5
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar
EXPOSE 8080                                          
# 6
CMD ["lein", "run"]
