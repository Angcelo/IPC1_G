from audioop import mul
from datetime import datetime
from flask import Flask, request, jsonify

Usuario = []
Books = []
Prestamos = []

app = Flask(__name__)


@app.route("/", methods=['GET'])
def index():
    return "Hello World!"


@app.route("/usuarios", methods=['POST'])
def crearUsuario():
    body = request.get_json()
    if body is None:
        return jsonify({"status": 400, "msg": "Solicitud incorrecta"})
    for i in range(len(Usuario)):
        if Usuario[i]['id_user'] == body['id_user']:
            return jsonify({"status": 400, "msg": "Usuario ya registrado"})
    if body['id_user'] != None and body['user_display_name'] != None \
            and body['user_nickname'] != None \
            and ['user_password'] != None \
            and ['user_age'] != None \
            and ['user_career'] != None \
            and ['user_carnet'] != None:
        Usuario.append({
            'id_user': body['id_user'],
            'user_display_name': body['user_display_name'],
            'user_nickname': body['user_nickname'],
            'user_password': body['user_password'],
            'user_age': body['user_age'],
            'user_career': body['user_career'],
            'user_carnet': body['user_carnet']
        })
        return jsonify({"status": 201, "msg": "Usuario registrado"})
    return jsonify({"status": 400, "msg": "Solicitud"})


@app.route('/usuarios', methods=['GET'])
def verUsuarios():
    return jsonify(Usuario)

# {
#   user_nickname: "",
#   user_password: ""
# }


@app.route('/login', methods=['POST'])
def login():
    body = request.get_json()
    for i in range(len(Usuario)):
        if Usuario[i]['user_nickname'] == body['user_nickname']:
            if Usuario[i]['user_password'] == body['user_password']:
                return jsonify({"status": 200, "msg": Usuario[i]['id_user']})
    return jsonify({"status": 400, "msg": "Credenciales incorrectas"})

# {
#   "id_book": 1
#   "book_title": "name_book"
#   "book_type": "Libro"
#   "auhor": "Nombre"
#   "book_count":150
#   "book_aviable": 50
#   "book_yeear": 2022
#   "book_editorial": "USAC Editorial"
# }


@app.route('/book', methods=["POST"])
def crearLibro():
    body = request.get_json()
    if body is None:
        return jsonify({"status": 400, "msg": "Solicitud incorrecta"})
    for i in range(len(Books)):
        if Books[i]['id_book'] == body['id_book']:
            return jsonify({"status": 400, "msg": "Libro ya registrado"})
    if body['id_book'] != None \
            and body['book_title'] != None \
            and body['book_type'] != None \
            and body['auhor'] != None \
            and body['book_count'] != None \
            and body['book_aviable'] != None \
            and body['book_year'] != None \
            and body['book_editorial'] != None:
        Books.append({
            'id_book': body['id_book'],
            'book_title': body['book_title'],
            'book_type': body['book_type'],
            'auhor': body['auhor'],
            'book_count': body['book_count'],
            'book_aviable': body['book_aviable'],
            'book_year': body['book_year'],
            'book_editorial': body['book_editorial']
        })
        return jsonify({"status": 201, "msg": "Libro registrado"})
    return jsonify({"status": 400, "msg": "Solicitud incorrecta"})


@app.route('/book', methods=["PUT"])
def actualizarLibro():
    body = request.get_json()
    if body is None:
        return jsonify({"status": 400, "msg": "Solicitud incorrecta"})
    if body['id_book'] == None:
        return jsonify({"status": 400, "msg": "Solicitud incorrecta"})
    for i in range(len(Books)):
        if Books[i]['id_book'] == body['id_book']:
            Books.remove(Books[i])
            Books.append({
                "id_book": body['id_book'],
                'book_title': body['book_title'],
                'book_type': body['book_type'],
                'auhor': body['auhor'],
                'book_count': body['book_count'],
                'book_aviable': body['book_aviable'],
                'book_year': body['book_year'],
                'book_editorial': body['book_editorial']
            })
            return jsonify({"status": 200, "msg": "Libro actualizado"})
    return jsonify({"status": 400, "msg": "Libro no encontrado"})


@app.route('/book', methods=["GET"])
def verLibros():
    return jsonify(Books)
# {
#   "id_book": 1
#   "id_user": 1
# }


@app.route('/loan', methods=["POST"])
def registrarPrestamo():
    body = request.get_json()
    Libro = None
    for i in range(len(Books)):
        if Books[i]['id_book'] == body['id_book']:
            Libro = Books[i]
            break
    if Libro == None:
        return jsonify({"status": 400, "msg": "Libro no existe"})
    User = None
    for i in range(len(Books)):
        if Usuario[i]['id_user'] == body['id_user']:
            User = Usuario[i]
            break
    if User == None:
        return jsonify({"status": 401, "msg": "No autorizado"})
    id = len(Prestamos) + 1
    now = datetime.now()
    print(now.date())
    if body['date'] == None:
        return jsonify({"status": 400, "msg": "Fecha no ingresada"})
    fecha = datetime.strptime(body['date'], '%Y-%m-%d')
    Prestamos.append({
        "id_loan": id,
        "id_usuario": body['id_user'],
        "id_book": body['id_book'],
        "date_inital": fecha.date(),
        "penalty_fee": 0
    })
    return jsonify({"status": 200, "msg": "Prestamos realizado"})

@app.route('/loan', methods=["PUT"])
def calcularMulta():
    body = request.get_json()
    for i in range(len(Prestamos)):
        if Prestamos[i]['id_loan'] == body['id_loan']:
            now = datetime.now()
            if now.date() > Prestamos[i]['date_inital']:
                multa = (now.date() - Prestamos[i]['date_inital']).days
                Prestamos[i]['date_inital'] = now.date()
                multa = multa - 7
                if multa > 0:
                    Prestamos[i]['penalty_fee'] = multa * 7.00
                    return jsonify({
                        "id_loan": Prestamos[i]['id_loan'],
                        "book_title": "Ya lo buscamos",
                        "loan_date": Prestamos[i]['date_inital'],
                        "return_date": now.date(),
                        "user_display_name": "Ya lo buscamos",
                        "penalty_fee":  multa*7.00
                    })
                return jsonify({"status": 200, "msg": "No hay multa"})
            return jsonify({"status": 200, "msg": "No hay multa"})
    return jsonify({"status": 400, "msg": "Prestamo no encontrado"})

if __name__ == '__main__':
    app.run(debug=True, port=5000)
