

# Support Multi-modal
We can integrate more than one modal in the spring AI.

a. Disable the default chat client bean creation using `spring.ai.chat.client.enabled=false`

b. Add all the configuration for the respective modal.


## Running Ollama in local container
1. Simply run the docker container which has 2 sections
    a. Ollama container: It just container without any models
    b. Open UI: UI interface similar to GPT which connnects your local Ollama container.

2. List the models running inside the `ollama` container
`docker exec -it ollama ollama list`

3. Install the lightweight model for local development.
`docker exec -it ollama ollama pull qwen2:0.5b`

In that case don't forget to update application.properties file also
```spring.ai.ollama.chat.options.model=qwen2:0.5b```






