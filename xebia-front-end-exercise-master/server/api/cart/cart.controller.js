'use strict';

var _ = require('lodash');
var Cart = require('./cart.model');

// Get list of carts
exports.index = function(req, res) {
  Cart.find(function(err, carts) {
    if (err) { return handleError(res, err); }
    return res.json(200, carts);
  });
};

// Get a single cart
exports.show = function(req, res) {
  Cart.findById(req.params.id, function(err, cart) {
    if (err) { return handleError(res, err); }
    if (!cart) { return res.send(404); }
    return res.json(cart);
  });
};

// Creates a new cart in the DB.
exports.create = function(req, res) {
  Cart.create(req.body, function(err, cart) {
    if (err) { return handleError(res, err); }
    return res.json(201, cart);
  });
};

// Updates an existing cart in the DB.
exports.update = function(req, res) {
  if (req.body._id) { delete req.body._id; }
  Cart.findById(req.params.id, function(err, cart) {
    if (err) { return handleError(res, err); }
    if (!cart) { return res.send(404); }
    var updated = _.merge(cart, req.body);
    updated.save(function(err) {
      if (err) { return handleError(res, err); }
      return res.json(200, cart);
    });
  });
};

// Deletes a cart from the DB.
exports.destroy = function(req, res) {
  Cart.findById(req.params.id, function(err, cart) {
    if (err) { return handleError(res, err); }
    if (!cart) { return res.send(404); }
    cart.remove(function(err) {
      if (err) { return handleError(res, err); }
      return res.send(204);
    });
  });
};

// Checkout a cart.
exports.checkout = function(req, res) {
  var cart = new Cart({
    items: req.body.data.items,
    discount: req.body.data.shipping,
    date: new Date(),
    total: req.body.data.totalCost,
    userId: req.user._id
  });
  cart.save(function(err, cart) {
    if (err) { handleError(res, err); }
    return res.json(201, cart);
  });
};

// Get carts for connected user.
exports.findByUser = function(req, res) {
  Cart.find({userId: req.user._id}, function(err, carts) {
    if (err) { handleError(res, err) }
    return res.json(200, carts);
  });
};

function handleError(res, err) {
  return res.send(500, err);
}
