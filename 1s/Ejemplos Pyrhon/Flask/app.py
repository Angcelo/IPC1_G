from flask import Flask, jsonify, request

app = Flask(__name__)

listaVehiculos = []

class Vehiculo:
    tipo = ""
    marca = ""

@app.route('/', methods=['GET'])
def hello():
    return 'Hello World!'

@app.route('/', methods=['POST'])
def hello_post():
    body = request.get_json()
    nombre = body['nombre']
    contrasena = body['contrasena']
    return 'hello {} {}'.format(nombre, contrasena)

@app.route('/vehiculos', methods=['POST'])
def vehiculos_post():
    body = request.get_json()
    tipo = body['tipo']
    nombre = body['nombre']
    vehiculo = Vehiculo
    vehiculo.tipo = tipo
    vehiculo.marca = nombre 
    listaVehiculos.append(vehiculo)
    return 'Vehiculo creado'

@app.route('/vehiculos', methods=['GET'])
def vehiculos_get():
    listaJson = []
    for vehiculo in listaVehiculos:
        listaJson.append({'tipo': vehiculo.tipo, 'marca': vehiculo.marca})
    return jsonify(listaJson)

if __name__ == '__main__':
    app.run(debug=True, port=5000)


