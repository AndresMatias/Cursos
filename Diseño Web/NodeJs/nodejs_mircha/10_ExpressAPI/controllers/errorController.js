const error404 = (req, res) => {
  res.status(404).json({ //aca reemplaze el metodo render por json proque en el modelo api como estoy del lado del servidor no nececito renderizar nada
    code: 404,
    message: "Not Found",
  });
};

export default {
  error404,
};
