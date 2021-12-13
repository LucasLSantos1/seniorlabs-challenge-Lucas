# seniorlabs-challenge-Lucas

## Ao subir a aplicação localmente a requisição deve ser enviada para a seguinte URL:

localhost:8080/api-registroPonto/registroPonto

## A aplicação também está disponível na cloud através da URL:

http://ec2-3-141-36-40.us-east-2.compute.amazonaws.com:8080/api-registroPonto/registroPonto

## Exemplo de requisição:
{
  "employeeId": 8717, 
  "employerId": 134
} 

## Exemplo de resposta:

{
	"employeeId": " 8717 ",
	"employerId": "134 ",
	"includedAt": "2021-12-13T05:10:32.064138700"
}

## Tratativa de Erros
### Ao enviar a requisição com algum dos campos obrigatórios (employeeId e employerId) pendentes, a seguinte mensagem de erro é retornada:
Entrada inválida, favor verificar os campos 'employerId'  e 'employeeId'
